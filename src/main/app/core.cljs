(ns app.core
  (:require ["/aws-exports" :default ^js aws-exports]
            ["aws-amplify" :default Amplify]
            [app.auth :as auth]
            [app.views :as views]
            [reagent.dom :as rdom]
            [re-frame.core :as rf]))

(def root-element (-> js/document (.getElementById "root")))

(defn app []
  [:> (-> views/panels
          auth/with-auth)])

(defn start []
  (rdom/render [app] root-element))

(defn init []
  (-> js/console (.log "Initializing app with AWS Amplify"))
  (-> Amplify (.configure aws-exports))
  (rf/dispatch-sync [:app/init])
  (start))
