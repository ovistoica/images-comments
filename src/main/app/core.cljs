(ns app.core
  (:require ["/aws-exports" :default ^js aws-exports]
            ["aws-amplify" :default Amplify]
            [reagent.dom :as rdom]
            [re-frame.core :as rf]
            [app.router :as router]
            [app.events]
            [app.subs]
    ;; designs
            [app.design.events]
            [app.design.subs]
    ;; Draft
            [app.create-designs.events]
            [app.create-designs.subs]
    ;; Nav
            [app.nav.subs]
            [app.nav.events]
            [app.nav.views :refer [app-pages]]
            [app.auth :as auth]))



(def root-element (-> js/document (.getElementById "root")))

(defn app []
  [:> (-> app-pages
          auth/with-auth)])

(defn ^:dev/after-load start []
  (rf/clear-subscription-cache!)
  (router/init-routes!)
  (rf/dispatch [:nav/push-state :create-design])
  (rdom/render [app] root-element))

(defn init []
  (-> js/console (.log "Initializing app with AWS Amplify"))
  (-> Amplify (.configure aws-exports))
  (rf/dispatch-sync [:app/init])
  (start))

