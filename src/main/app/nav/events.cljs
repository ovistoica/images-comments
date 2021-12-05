(ns app.nav.events
  (:require [re-frame.core :as rf]
            [reitit.frontend.easy :as rtfe]
            [reitit.frontend.controllers :as rtfc]))
;;; Effects ;;;

(rf/reg-fx
  :push-state
  (fn [route]
    (apply rtfe/push-state route)))

;;; Events ;;;

(rf/reg-event-fx
  :nav/push-state
  (fn [_ [_ & route]]
    {:push-state route}))

(rf/reg-event-db
  :nav/set-current-route
  (fn [db [_ new-match]]
    (let [old-match (:current-route db)]
      (rtfc/apply-controllers (:controllers old-match) new-match)
      (assoc-in db [:app :nav :current-route] new-match))))
