(ns app.router
  (:require [spec-tools.data-spec :as ds]
            [reitit.core :as rt]
            [reitit.frontend :as rtf]
            [reitit.frontend.easy :as rtfe]
            [reitit.frontend.controllers :as rtfc]
            [reitit.coercion.spec :as rss]
            [app.design.views :refer [designs-controllers designs-page]]
            [app.create-designs.views :refer [create-design-controllers create-design]]
            [re-frame.core :as rf]))

(def routes
  [""
   ["/designs"
    {:name        :design-screen
     :view        designs-page
     :link-text   "Designs"
     :controllers designs-controllers}]
   ["/create"
    {:name        :create-design
     :view        create-design
     :link-text   "Create Design"
     :controllers create-design-controllers}]])

(defn on-navigate [new-match]
  (when new-match
    (rf/dispatch [:nav/set-current-route new-match])))

(def router
  (rtf/router
    routes
    {:data {:coercion rss/coercion}}))

(defn init-routes! []
  (js/console.log "initializing routes") (rtfe/start!
    router
    on-navigate
    {:use-fragment true}))

;;; Setup ;;;

(def debug? ^boolean goog.DEBUG)

(defn dev-setup []
  (when debug?
    (enable-console-print!)
    (println "dev mode")))

