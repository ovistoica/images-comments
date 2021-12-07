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


#_(defn create-design []
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


(defn create-design []
  [:div.container.mx-auto.w-full
   [:div {:class "md:grid md:grid-cols-3 md:gap-6"}
    [:div {:class "mt-5 md:mt-0 md:col-span-2"}
     [:form {:action "#" :method "POST"}
      [:div {:class "shadow sm:rounded-md sm:overflow-hidden"}
       [:div {:class "px-4 py-5 bg-white space-y-6 sm:p-6"}
        [:div {:class "grid grid-cols-3 gap-6"}
         [:div {:class "col-span-3 sm:col-span-2"}
          [:label {:htmlFor "company-website" :class "block text-sm font-medium text-gray-700"} "Website"]
          [:div {:class "mt-1 flex rounded-md shadow-sm"}
           [:span {:class "inline-flex items-center px-3 rounded-l-md border border-r-0 border-gray-300 bg-gray-50 text-gray-500 text-sm"} "http://"]
           [:input#company-website {:type "text" :name "company-website" :class "focus:ring-indigo-500 focus:border-indigo-500 flex-1 block w-full rounded-none rounded-r-md sm:text-sm border-gray-300" :placeholder "www.example.com"}]]]]
        [:div
         [:label {:htmlFor "about" :class "block text-sm font-medium text-gray-700"} "About"]
         [:div {:class "mt-1"}
          [:textarea#about {:name "about" :rows "{3}" :class "shadow-sm focus:ring-indigo-500 focus:border-indigo-500 mt-1 block w-full sm:text-sm border border-gray-300 rounded-md" :placeholder "you@example.com" :defaultValue "{''}"}]]
         [:p {:class "mt-2 text-sm text-gray-500"} "Brief description for your profile. URLs are hyperlinked."]]
        [:div
         [:label {:class "block text-sm font-medium text-gray-700"} "Photo"]
         [:div {:class "mt-1 flex items-center"}
          [:span {:class "inline-block h-12 w-12 rounded-full overflow-hidden bg-gray-100"}
           [:svg {:class "h-full w-full text-gray-300" :fill "currentColor" :viewBox "0 0 24 24"}
            [:path {:d "M24 20.993V24H0v-2.996A14.977 14.977 0 0112.004 15c4.904 0 9.26 2.354 11.996 5.993zM16.002 8.999a4 4 0 11-8 0 4 4 0 018 0z"}]]]
          [:button {:type "button" :class "ml-5 bg-white py-2 px-3 border border-gray-300 rounded-md shadow-sm text-sm leading-4 font-medium text-gray-700 hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"} "Change"]]]
        [:div
         [:label {:class "block text-sm font-medium text-gray-700"} "Cover photo"]
         [:div {:class "mt-1 flex justify-center px-6 pt-5 pb-6 border-2 border-gray-300 border-dashed rounded-md"}
          [:div {:class "space-y-1 text-center"}
           [:svg {:class "mx-auto h-12 w-12 text-gray-400" :stroke "currentColor" :fill "none" :viewBox "0 0 48 48" :aria-hidden "true"}
            [:path {:d "M28 8H12a4 4 0 00-4 4v20m32-12v8m0 0v8a4 4 0 01-4 4H12a4 4 0 01-4-4v-4m32-4l-3.172-3.172a4 4 0 00-5.656 0L28 28M8 32l9.172-9.172a4 4 0 015.656 0L28 28m0 0l4 4m4-24h8m-4-4v8m-12 4h.02" :strokeWidth "{2}" :strokeLinecap "round" :strokeLinejoin "round"}]]
           [:div {:class "flex text-sm text-gray-600"}
            [:label {:htmlFor "file-upload" :class "relative cursor-pointer bg-white rounded-md font-medium text-indigo-600 hover:text-indigo-500 focus-within:outline-none focus-within:ring-2 focus-within:ring-offset-2 focus-within:ring-indigo-500"}
             [:span "Upload a file"]
             [:input#file-upload {:name "file-upload" :type "file" :class "sr-only"}]]
            [:p {:class "pl-1"} "or drag and drop"]]
           [:p {:class "text-xs text-gray-500"} "PNG, JPG, GIF up to 10MB"]]]]]
       [:div {:class "px-4 py-3 bg-gray-50 text-right sm:px-6"}
        [:button {:type "submit" :class "inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"} "Save"]]]]]]])





