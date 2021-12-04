(ns app.design.api
  (:require ["/graphql/queries" :refer [^js listDesigns]]
            ["aws-amplify" :refer [API graphqlOperation]]))


(defn- designs-data [^js data]
  (-> data
      (js->clj :keywordize-keys true)
      :data
      :listDesigns
      :items))

(defn get-designs [{:keys [success-fn failure-fn]}]
  (-> (.graphql API (graphqlOperation listDesigns))
      (.then #(-> % designs-data success-fn))
      (.catch failure-fn)))
