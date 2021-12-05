(ns app.nav.subs
  (:require [re-frame.core :as rf]))

;;; Subscriptions ;;;
(rf/reg-sub
  :nav/current-route
  (fn [db]
    (-> db :app :nav :current-route)))
