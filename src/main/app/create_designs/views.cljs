(ns app.create-designs.views
  (:require [reagent.core :as r]
            [app.aws.storage :as storage]
            [re-frame.core :as rf]
            [clojure.string :as str]
            [app.helpers :refer [classes]]
            ["@heroicons/react/solid" :refer [CloudUploadIcon]]))


(def create-design-controllers [])


(defn get-value
  [^js/Event e]
  (.. e -target -value))

(defn form-group
  [{:keys [id label type values placeholder class]}]
  [:div.mb-4
   [:label.block.text-gray-700.text-sm.font-bold.mb-2 {:for id}
    label
    [:input.form-input
     {:id          id
      :type        type
      :placeholder placeholder
      :value       (id @values)
      :on-change   #(swap! values assoc id (get-value %))}]]])

(defn file-form []
  [:label {:class (classes "w-64 flex flex-col items-center px-4 py-6 bg-white rounded-md"
                           "shadow-md tracking-wide uppercase border border-blue cursor-pointer "
                           "hover:bg-blue-600 hover:text-white text-blue-600 ease-linear transition-all"
                           "duration-150")}
   [:> CloudUploadIcon {:class "h-20 w-20 pt-2"}]
   [:span.mt-2.text-base.leading-normal "Select images"]
   [:input.hidden {:type      :file
                   :on-change #(rf/dispatch [:draft/set-image (-> % .-target .-files first)])}]])


(defn create-design []
  (let [initial-values {:name "" :context ""}
        values (r/atom initial-values)
        save (fn [{:keys [name context]}]
               (rf/dispatch [:draft/create-design
                             {:id      (random-uuid)
                              :name    (str/trim name)
                              :context (str/trim context)}])
               (reset! values initial-values))]
    (fn []
      (let [image @(rf/subscribe [:draft/image])
            name @(rf/subscribe [:draft/name])]
        [:div.flex.items-center.flex-col
         [form-group {:id          :name
                      :label       "Design name"
                      :type        "text"
                      :placeholder "A design name"
                      :values      values}]
         [form-group {:id          :context
                      :label       "Design context"
                      :type        "text"
                      :placeholder "What is this project about? Set the context, the goals, the constraints."
                      :values      values}]
         [file-form]

         (when image
           [:div.flex.flex-col
            [:img.mt-4.rounded.shadow {:src    (js/URL.createObjectURL ^js/File image)
                                       :width  "500px"
                                       :height "500px"}]
            [:button.bg-blue-400.p-4.rounded.text-white.mt-4
             {:on-click #(-> (storage/put-file name image)
                             (.then js/console.log))} "Upload image"]])]))))
