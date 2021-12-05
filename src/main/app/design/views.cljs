(ns app.design.views
  (:require [re-frame.core :as rf]))

(def designs-controllers [{}])

(defn designs-page []
  (let [username @(rf/subscribe [:app/user-name])
        designs @(rf/subscribe [:designs])]
    [:div.container.px-4
     [:h1.text-2xl.font-bold "This is the designs page"]
     [:div.mt-2.grid.justify-items-center.grid-cols-3
      (for [design designs]
        ^{:key (:id design)}
        [:div {:class "shadow h-[100px] w-[100px] bg-blue-100 flex items-center justify-center"}
         [:p (:name design)]])]]))

