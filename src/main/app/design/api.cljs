(ns app.design.api
  (:require ["/graphql/queries" :refer [^js listDesigns]]
            ["/graphql/mutations" :refer [^js createDesign]]
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

(defn- create-design-query [{:keys [name context]}]
  (clj->js {:query     createDesign
            :variables {:input {:context context
                                :name    name}}}))

(defonce db (atom {}))

(defn capture-result [result]
  (reset! db result))


(defn create-design [{:keys [design-draft success-fn failure-fn]}]
  (-> (.graphql API (graphqlOperation createDesign (clj->js {:input design-draft})))
      (.then success-fn)
      (.catch failure-fn)))

(comment

  @db
  (def id (str (random-uuid)))

  (get-designs {:success-fn capture-result
                :failure-fn capture-result})

  (create-design {:design-draft {:name    "from-repl2"
                                 :context "Design created from REPL"
                                 :id      id}
                  :success-fn   capture-result
                  :failure-fn   capture-result}))
