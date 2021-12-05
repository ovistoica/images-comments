(ns app.aws.ui
  (:require ["@aws-amplify/ui-react" :refer [Flex Icon IconNotifications Image SearchField Text]]
            [reagent.core :as r]))

(def flex (r/adapt-react-class Flex))
(def icon (r/adapt-react-class Icon))
(def icon-notifications (r/adapt-react-class IconNotifications))
(def image (r/adapt-react-class Image))
(def search-field (r/adapt-react-class SearchField))
(def text (r/adapt-react-class Text))

(defn navbar []
  [flex {:padding }])
