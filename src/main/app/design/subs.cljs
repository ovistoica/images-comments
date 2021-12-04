(ns app.design.subs
  (:require [re-frame.core :as rf]))

(rf/reg-sub
  :designs
  (fn [db]
    (get-in db [:app :designs :data])))
