(ns app.views)

(defn header []
  [:h2 "Clojure. Amplified."])

(defn welcome [name]
  [:p "Hello " [:strong name]])

(defn panels []
  [:div {:style {:max-width "350px"}}
   [header]
   [welcome "ClojureScript developer"]])
