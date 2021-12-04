(ns app.views
  (:require [re-frame.core :as rf]))

(defn header []
  [:h2 "Clojure. Amplified."])

(defn welcome [name]
  [:p "Hello " [:strong name]])

(defn panels []
  (let [username @(rf/subscribe [:app/user-name])]
    [:div {:style {:max-width "350px"}}
     [header]
     [welcome username]]))



