(ns app.design.views
  (:require [re-frame.core :as rf]))

(def designs-controllers [{}])

(defn designs-page []
  (let [username @(rf/subscribe [:app/user-name])
        designs @(rf/subscribe [:designs])]

    [:div
     [:h1 "This is the designs page"]
     [:p "Hi there user" username]
     (for [design designs]
       ^{:key (:id design)}
       [:p (:name design)])]))

