(ns app.auth
  (:require ["@aws-amplify/ui-react" :refer [withAuthenticator]]
            ["aws-amplify" :refer [Auth Hub]]
            [reagent.core :as reagent]))

;; TODO: a real world example should have things like retries and error messages in the UI.
(defn- failed [e]
  (-> js/console (.error e)))

(defn- on-signed-out [_]
  (-> js/window .-location .reload))

(defn- js->attributes [^js data]
  (-> data
      .-attributes
      (js->clj :keywordize-keys true)))

(defn- js->user-data [^js data]
  (assoc (js->attributes data) :username (-> data .-username)))

(defn- js->event [^js data]
  (-> data
      .-payload
      .-event
      keyword))

(defn sign-out []
  (-> Auth
      .signOut
      (.then on-signed-out)
      (.catch failed)))

(defn user! [success-fn]
  (-> Auth
      .currentAuthenticatedUser
      (.then #(-> % js->user-data success-fn))
      (.catch failed)))

(defn listen-to-auth-events [callback]
  (-> Hub
      (.listen "auth" #(-> % js->event callback))))

(defn with-auth [component]
  (-> component
      reagent/reactify-component
      (withAuthenticator (clj->js {:includeGreetings true
                                   :loginMechanisms  ["email"]
                                   :signUpAttributes ["email"]}))))
