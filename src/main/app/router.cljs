(ns app.router
  (:require [spec-tools.data-spec :as ds]
            [reitit.core :as rt]
            [reitit.frontend :as rtf]
            [reitit.frontend.easy :as rtfe]
            [reitit.frontend.controllers :as rtfc]
            [reitit.coercion.spec :as rss]
            [app.design.views :refer [designs-controllers designs-page]]
            [re-frame.core :as rf]))


;;; Effects ;;;

(rf/reg-fx
  :push-state
  (fn [route]
    (apply rtfe/push-state route)))

;;; Events ;;;

(rf/reg-event-fx
  :nav/push-state
  (fn [_ [_ & route]]
    {:push-state route}))

(rf/reg-event-db
  :nav/set-current-route
  (fn [db [_ new-match]]
    (let [old-match (:current-route db)
          controllers (rtfc/apply-controllers (:controllers old-match) new-match)]
      (assoc-in db [:app :nav :current-route] (assoc new-match :controllers controllers)))))

;;; Subscriptions ;;;
(rf/reg-sub
  :nav/current-route
  (fn [db]
    (-> db :app :nav :current-route)))

;;; Routes ;;;

(defn href
  "Return relative url for given route. Url can be used in HTML links."
  ([k]
   (href k nil nil))
  ([k params]
   (href k params nil))
  ([k params query]
   (rtfe/href k params query)))

(def routes
  [""
   ["/designs"
    {:name        :design-screen
     :view        designs-page
     :link-text   "Designs"
     :controllers designs-controllers}]])

(defn on-navigate [new-match]
  (when new-match
    (rf/dispatch [:nav/set-current-route new-match])))

(def router
  (rtf/router
    routes
    {:data {:coercion rss/coercion}}))

(defn init-routes! []
  (js/console.log "initializing routes")
  (rtfe/start!
    router
    on-navigate
    {:use-fragment true}))

(defn nav [{:keys [router current-route]}]
  [:ul
   (for [route-name (rt/route-names router)
         :let [route (rt/match-by-name router route-name)
               text (-> route :data :link-text)]]
     [:li {:key route-name}
      (when (= route-name (-> current-route :data :name))
        "> ")
      ;; Create a normal links that user can click
      [:a {:href (href route-name)} text]])])

(defn router-component []
  (let [current-route @(rf/subscribe [:nav/current-route])]
    [:div
     [nav {:router router :current-route current-route}]
     (when current-route
       [(-> current-route :data :view)])]))

;;; Setup ;;;

(def debug? ^boolean goog.DEBUG)

(defn dev-setup []
  (when debug?
    (enable-console-print!)
    (println "dev mode")))

