(ns app.core
  (:require ["/aws-exports" :default ^js aws-exports]
            ["aws-amplify" :default Amplify]
            [app.events]
            [app.subs]
    ;; designs
            [app.design.events]
            [app.design.subs]

            [app.router :as router]
            [app.auth :as auth]
            [app.views :as views]

            [reagent.dom :as rdom]
            [re-frame.core :as rf]))

(def root-element (-> js/document (.getElementById "root")))

(defn app []
  [:> (-> router/router-component
          auth/with-auth)])

(defn ^:dev/after-load start []
  (rf/clear-subscription-cache!)
  (router/init-routes!)
  (rdom/render [app] root-element))

(defn init []
  (-> js/console (.log "Initializing app with AWS Amplify"))
  (-> Amplify (.configure aws-exports))
  (rf/dispatch-sync [:app/init])
  (start))
