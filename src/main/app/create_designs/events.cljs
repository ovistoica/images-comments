(ns app.create-designs.events
  (:require [re-frame.core :as rf]
            [app.design.api :as design-api]))


(rf/reg-event-db
  :draft/set-image
  (fn [db [_ image]]
    (assoc-in db [:draft :image] (js->clj image :keywordize-keys true))))

(rf/reg-event-db
  :draft/set-image
  (fn [db [_ image]]
    (assoc-in db [:draft :image] image)))

(rf/reg-fx
  :design/create
  (fn [design]
    (design-api/create-design
      {:design-draft design
       :success-fn   js/console.log
       :failure-fn   js/console.log})))


(rf/reg-event-fx
  :design/create-db-design
  (fn [{:keys [db]} [_ {:keys [id name context]}]]
    {:design/create {:id      id
                     :name    name
                     :context context}}))


;;1. Upload image/s
;;2. Get image url
;;3. Create design and shots entries
;;4.
;;
;;

