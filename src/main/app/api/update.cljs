(ns app.api.update
  (:require ["/graphql/mutations" :refer [^js createDesign]]
            ["aws-amplify" :refer [API]]))

;; TODO: a Real world example should have things like retries and error messages in the UI.
(defn- failed [e]
  (-> js/console (.error e)))



(defn- create-design-js-object [{:keys [name context]}]
  (clj->js {:query     createDesign
            :variables {:input {:id      (str (random-uuid))
                                :context context
                                :name    name}}}))

(defn create-design [data success-fn]
  (-> API
      (.graphql (create-design-js-object data))
      (.then success-fn)
      (.catch failed)))


(create-design {:name "New design"
                :context "New design context"} js/console.log)
