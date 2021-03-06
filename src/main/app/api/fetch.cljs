(ns app.api.fetch
  (:require ["/graphql/queries" :refer [^js listDesigns]]
            ["aws-amplify" :refer [API graphqlOperation]]))

;; TODO: a Real world example should have things like retries and error messages in the UI.
(defn- failed [e]
  (-> js/console (.error e)))

(defn- designs-data [^js data]
  (-> data
      (js->clj :keywordize-keys true)
      :data
      :listDesigns
      :items))

(defn get-designs [success-fn]
  (-> API
      (.graphql (graphqlOperation listDesigns))
      (.then #(-> % designs-data success-fn))
      (.catch failed)))




