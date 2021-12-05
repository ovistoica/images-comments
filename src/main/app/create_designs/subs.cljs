(ns app.create-designs.subs
  (:require [re-frame.core :as rf]))


(rf/reg-sub
  :draft/image
  (fn [db _]
    (get-in db [:draft :image])))

(rf/reg-sub
  :draft/name
  :<- [:draft/image]
  (fn [image]
    (when image
      (aget image "name"))))
