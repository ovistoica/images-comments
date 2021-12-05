(ns app.create-designs.events
  (:require [re-frame.core :as rf]))


(rf/reg-event-db
  :draft/set-image
  (fn [db [_ image]]
    (assoc-in db [:draft :image] (js->clj image :keywordize-keys true))))

(rf/reg-event-db
  :draft/set-image
  (fn [db [_ image]]
    (assoc-in db [:draft :image] image)))


