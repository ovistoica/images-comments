(ns app.helpers
  (:require [clojure.string :as string]
            [goog.string :as gstring]))
;; Local storage

(defn set-item-ls!
  [key item]
  (.setItem js/localStorage key (str item)))

(defn remove-item-ls!
  [key]
  (.removeItem js/localStorage key))

(defn get-item-ls
  [key]
  (.getItem js/localStorage key))

;; Tailwind helpers
(defn classes
  "Join multiple classes into a single string.

  Also filters falsy parameters"
  [& classes]
  (string/join " " (filter string? classes)))


(defn unescape-html
  [entities]
  (gstring/unescapeEntities entities))

