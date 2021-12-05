(ns app.design.events
  (:require [re-frame.core :as rf]
            [app.design.api :as api]))

(rf/reg-event-db
  :designs/store-designs
  (fn [db [_ designs]]
    (-> db
        (assoc-in [:designs :data] designs)
        (assoc-in [:designs :loading?] false))))

(rf/reg-event-db
  :designs/notify-failure
  (fn [db [_ error]]
    (-> db
        (assoc-in [:designs :loading?] false)
        (assoc-in [:errors :designs] error))))

(rf/reg-fx
  :designs/fetch
  (fn [req]
    (api/get-designs
      {:success-fn #(rf/dispatch [(:on-success req) %])
       :failure-fn #(rf/dispatch [(:on-failure req) %])})))

(rf/reg-event-fx
  :designs/load
  (fn [{:keys [db]} _]
    {:designs/fetch {:on-success :designs/store-designs
                     :on-failure :designs/notify-failure}

     :db            (assoc-in db [:designs :loading?] true)}))
