(ns app.nav.views
  (:require [reitit.core :as rt]
            [re-frame.core :as rf]
            [reitit.frontend.easy :as rtfe]
            [app.router :refer [router]]))

(defn href
  "Return relative url for given route. Url can be used in HTML links."
  ([k]
   (href k nil nil))
  ([k params]
   (href k params nil))
  ([k params query]
   (rtfe/href k params query)))


(defn nav-link
  [{:keys [id href name dispatch active-page]}]
  (let [active? (= active-page id)]
    [:a {:key      id
         :href     href
         :class    (str "pb-2 mx-3 " (when active? "text-blue-500 border-blue-500 border-b-2"))
         :pb       10
         :on-click dispatch} name]))

(defn nav [{:keys [router current-route]}]
  (let [all-routes (rt/route-names router)]
    [:nav.flex.py-4
     (for [route-name all-routes
           :let [route (rt/match-by-name router route-name)
                 link-text (-> route :data :link-text)]]
       [nav-link {:id          route-name
                  :active-page (-> current-route :data :name)
                  :href        (href route-name)
                  :name        link-text}])]))

(defn router-component [{:keys [router]}]
  (let [current-route @(rf/subscribe [:nav/current-route])]
    [:div.container.bg-gray-100
     [nav {:router router :current-route current-route}]
     (when current-route
       [(-> current-route :data :view)])]))

(defn app-pages []
  [router-component {:router router}])
