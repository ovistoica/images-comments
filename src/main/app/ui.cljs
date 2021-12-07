(ns app.ui
  (:require ["@headlessui/react" :refer [Disclosure Menu Switch Transition Tab Dialog]]
            ["@heroicons/react/solid" :refer [ChevronUpIcon]]
            ["@heroicons/react/outline" :refer [BellIcon MenuIcon XIcon]]
            ["react" :refer [Fragment]]
            [reagent.core :as r]
            [reitit.core :as rt]
            [reitit.frontend.easy :as rtfe]
            [app.helpers :refer [classes]]
            [app.auth :refer [sign-out]]
            [re-frame.core :as rf]))

(def disclosure (r/adapt-react-class Disclosure))
(def disclosure-button (r/adapt-react-class (aget Disclosure "Button")))
(def disclosure-panel (r/adapt-react-class (aget Disclosure "Panel")))



(def menu (r/adapt-react-class Menu))
(def menu-items (r/adapt-react-class (.-Items ^js Menu)))
(def menu-item (r/adapt-react-class (aget Menu "Item")))
(def menu-button (r/adapt-react-class (aget Menu "Button")))

(def switch (r/adapt-react-class Switch))

(def transition (r/adapt-react-class Transition))
(def transition-child
  "Used to coordinate multiple transitions based on the same event.
  Needs to be nested inside a transition element."
  (r/adapt-react-class (aget Transition "Child")))
(def transition-root
  (r/adapt-react-class (aget Transition "Root")))

(def fragment (r/adapt-react-class Fragment))

; Tabs
(def tab
  "Correct usage:
  [tab-group
   [tab-list
     [tab \"1\"]
     [tab \"2\"]
     [tab \"3\"]]
   [tab-panels
     [tab-panel \"1 Content\"]
     [tab-panel \"1 Content\"]
     [tab-panel \"2 Content\"]]]"
  (r/adapt-react-class Tab))
(def tab-group (r/adapt-react-class (aget Tab "Group")))
(def tab-list (r/adapt-react-class (aget Tab "List")))
(def tab-panels (r/adapt-react-class (aget Tab "Panels")))
(def tab-panel (r/adapt-react-class (aget Tab "Panel")))




;;;;;;;;;;;;;;;;;;;;;;;; Usages context ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

#_(defn- example-usage-tailwind-context
    []
    [:div {:class "w-full px-4 pt-16"}
     [:div {:class "w-full max-w-md p-2 mx-auto bg-white rounded-2xl"}
      [disclosure
       ;; here is how you define context
       (fn [disclosure-context]
         (let [props (js->clj disclosure-context :keywordize-keys true)]
           ;; The rest of the form needs to use r/as-element for returning
           (r/as-element
             [:<>
              [disclosure-button {:class "flex justify-between w-full px-4 py-2 text-sm font-medium text-left text-purple-900 bg-purple-100 rounded-lg hover:bg-purple-200 focus:outline-none focus-visible:ring focus-visible:ring-purple-500 focus-visible:ring-opacity-75"}
               [:span "What is your refund policy?"]
               [:> ChevronUpIcon {:class (str (when (:open props) "transform rotate-180 ") "w-5 h-5 text-purple-500")}]]
              [disclosure-panel {:class "px-4 pt-4 pb-2 text-sm text-gray-500"}
               "If you're unhappy with your purchase for any reason, email us within 90 days and we'll refund you in full, no questions asked."]])))]]])


(defn href
  "Return relative url for given route. Url can be used in HTML links."
  ([k]
   (href k nil nil))
  ([k params]
   (href k params nil))
  ([k params query]
   (rtfe/href k params query)))

(defn logo []
  [:div.flex-shrink-0
   [:img {:class "h-8 w-u"
          :src   "https://tailwindui.com/img/logos/workflow-mark-indigo-500.svg"
          :alt   "Designvote Logo"}]])

(defn notifications-button []
  [:button {:type  :button
            :class (classes "bg-gray-800 p-1 rounded-full text-gray-400 hover:text-white"
                            "focus:outline-none focus:ring-2 focus:ring-offset-2"
                            "focus:ring-offset-gray-800 focus:ring-white")}
   [:span.sr-only "View notifications"]
   [:> BellIcon {:class "h-6 w-6"}
    :aria-hidden true]])

(def mock-user {:name  "Tom Cook"
                :email "tom@example.com",
                :url   "https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80"})


(defn profile-dropdown [{:keys [router profile-routes]}]
  [menu {:as    :div
         :class "ml-3 relative"}
   [:div [menu-button {:class
                       (classes "max-w-xs bg-gray-800 rounded-full flex items-center text-sm focus:outline-none"
                                "focus:ring-2 focus:ring-offset-2 focus:ring-offset-gray-800 focus:ring-white")}
          [:span.sr-only "Open user menu"]
          [:img.h-8.w-8.rounded-full {:src (:url mock-user)}]]]
   [:> Transition {:as         Fragment
                   :enter      "transition ease-out duration-100"
                   :transform  "transform opacity-0 scale-95"
                   :enter-from "transform opacity-0 scale-95"
                   :enter-to   "transform opacity-100 scale-100"
                   :leave      "transition ease-in duration-75"
                   :leave-from "transform opacity-100 scale-100"
                   :leave-to   "transform opacity-0 scale-95"}
    [menu-items
     {:class (classes "origin-top-right absolute right-0 mt-2 w-48 rounded-md shadow-lg py-1 bg-white"
                      "ring-1 ring-black ring-opacity-5 focus:outline-none")}
     (for [route-name profile-routes
           :let [route (rt/match-by-name router route-name)
                 link-text (-> route :data :link-text)]]
       ^{:key (str "menu-item-" route-name)}
       [:div
        [menu-item
         (fn [menu-context]
           (let [active? (.-active ^js menu-context)]
             (r/as-element [:a {:href  (href route-name)
                                :class (classes "block px-4 py-2 text-sm text-gray-700"
                                                (when active? "bg-gray-100"))}
                            link-text])))]])
     [menu-item
      (fn [c]
        (let [active? (.-active ^js c)]
          (r/as-element [:a {:href     "#"
                             :on-click sign-out
                             :class    (classes "block px-4 py-2 text-sm text-gray-700"
                                                (when active? "bg-gray-100"))}
                         "Sign out"])))]]]])

(defn mobile-nav-profile
  []
  [:div {:class "pt-4 pb-3 border-t border-gray-700"}
   [:div {:class "flex items-center px-5"}
    [:div {:class "flex-shrink-0"}
     [:img {:class "h-10 w-10 rounded-full" :src (:url mock-user) :alt ""}]]
    [:div {:class "ml-3"}
     [:div {:class "text-base font-medium leading-none text-white"} (:name mock-user)]
     [:div {:class "text-sm font-medium leading-none text-gray-400"} (:email mock-user)]]
    [:button {:type "button" :class "ml-auto bg-gray-800 flex-shrink-0 p-1 rounded-full text-gray-400 hover:text-white focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-offset-gray-800 focus:ring-white"}
     [:span {:class "sr-only"} "View notifications"]
     [:> BellIcon {:class "h-6 w-6" :aria-hidden "true"}]]]])



(defn nav [{:keys [router current-route]}]
  (let [all-routes (rt/route-names router)
        active-route (-> current-route :data :name)]
    [disclosure {:as    "nav"
                 :class "bg-gray-800 w-screen"}
     (fn [disclosure-context]
       (let [open? (.-open ^js disclosure-context)]
         (r/as-element
           [:<>
            [:div {:class "max-w-7xl mx-auto px-4 sm:px-6 lg:px-8"}
             [:div {:class "flex items-center justify-between h-16"}
              [:div.flex.items-center
               [logo]
               [:div.hidden.md:block
                [:div.ml-10.flex.items-baseline.space-x-4
                 (for [route-name all-routes
                       :let [route (rt/match-by-name router route-name)
                             link-text (-> route :data :link-text)
                             active? (= active-route route-name)]]
                   ^{:key route-name}
                   [:a {:href         (href route-name)
                        :class        (classes "px-3 py-2 rounded-md text-sm font-medium"
                                               (if active?
                                                 "bg-gray-900 text-white"
                                                 "text-gray-300 hover:bg-gray-700 hover:text-white"))
                        :aria-current (if active? "page" nil)} link-text])]]]
              [:div.hidden.md:block
               [:div.ml-4.flex.items-center.md:ml-6
                [notifications-button]
                [profile-dropdown {:router         router
                                   :profile-routes [:profile]}]]]
              [:div.-mr-2.flex.md:hidden
               [disclosure-button
                {:class (classes "bg-gray-800 inline-flex items-center justify-center p-2 rounded-md"
                                 "text-gray-400 hover:text-white hover:bg-gray-700 focus:outline-none"
                                 "focus:ring-2 focus:ring-offset-2 focus:ring-offset-gray-800 focus:ring-white")}
                (r/as-element
                  [:span.sr-only "Open main menu"])
                (if open?
                  [:> XIcon {:class "block h-6 w-6" :aria-hidden true}]
                  [:> MenuIcon {:class "block h-6 w-6" :aria-hidden true}])]]]]
            [disclosure-panel {:class "md:hidden"}
             (r/as-element
               [:<>
                [:div {:class "px-2 pt-2 pb-3 space-y-1 sm:px-3"}
                 (for [route-name all-routes
                       :let [route (rt/match-by-name router route-name)
                             link-text (-> route :data :link-text)
                             active? (= active-route route)]]
                   ^{:key (str "mobile-menu-" route)}
                   [disclosure-button
                    {:as           "a"
                     :href         (href route-name)
                     :class        (classes "block px-3 py-2 rounded-md text-base font-medium"
                                            (if active? "bg-gray-900 text-white"
                                                        "text-gray-300 hover:bg-gray-700 hover:text-white"))
                     :aria-current (when active? "page")} link-text])]
                [mobile-nav-profile]])]])))]))

(defn app-layout [router]
  (let [current-route @(rf/subscribe [:nav/current-route])]
    [:div {:class "min-h-full"}
     [nav {:router router :current-route current-route}]
     [:header {:class "bg-white shadow"}
      [:div {:class "max-w-7xl mx-auto py-6 px-4 sm:px-6 lg:px-8"}
       [:h1 {:class "text-3xl font-bold text-gray-900"} (or (-> current-route :data :link-text) "Dashboard")]]]
     [:main
      [:div {:class "max-w-7xl mx-auto py-6 sm:px-6 lg:px-8"}
       (when current-route
         [(-> current-route :data :view)])]]]))
