(ns app.views)
(defn profile-page
  []
  [:div.bg-white.shadow.overflow-hidden.sm:rounded-lg
   [:div.px-4.py-5.sm:px-6
    [:h3.text-lg.leading-6.font-medium.text-gray-900 "Applicant Information"]
    [:p.mt-1.max-w-2xl.text-sm.text-gray-500 "Personal details and application."]]
   [:div.border-t.border-gray-200
    [:dl
     [:div.bg-gray-50.px-4.py-5.sm:grid.sm:grid-cols-3.sm:gap-4.sm:px-6
      [:dt.text-sm.font-medium.text-gray-500 "Full name"]
      [:dd.mt-1.text-sm.text-gray-900.sm:mt-0.sm:col-span-2 "Margot Foster"]]
     [:div.bg-white.px-4.py-5.sm:grid.sm:grid-cols-3.sm:gap-4.sm:px-6
      [:dt.text-sm.font-medium.text-gray-500 "Application for"]
      [:dd.mt-1.text-sm.text-gray-900.sm:mt-0.sm:col-span-2 "Backend Developer"]]
     [:div.bg-gray-50.px-4.py-5.sm:grid.sm:grid-cols-3.sm:gap-4.sm:px-6
      [:dt.text-sm.font-medium.text-gray-500 "Email address"]
      [:dd.mt-1.text-sm.text-gray-900.sm:mt-0.sm:col-span-2 "margotfoster@example.com"]]
     [:div.bg-white.px-4.py-5.sm:grid.sm:grid-cols-3.sm:gap-4.sm:px-6
      [:dt.text-sm.font-medium.text-gray-500 "Salary expectation"]
      [:dd.mt-1.text-sm.text-gray-900.sm:mt-0.sm:col-span-2 "$120,000"]]
     [:div.bg-gray-50.px-4.py-5.sm:grid.sm:grid-cols-3.sm:gap-4.sm:px-6
      [:dt.text-sm.font-medium.text-gray-500 "About"]
      [:dd.mt-1.text-sm.text-gray-900.sm:mt-0.sm:col-span-2 "Fugiat ipsum ipsum deserunt culpa aute sint do nostrud anim incididunt cillum culpa consequat. Excepteur qui ipsum aliquip consequat sint. Sit id mollit nulla mollit nostrud in ea officia proident. Irure nostrud pariatur mollit ad adipisicing reprehenderit deserunt qui eu."]]
     [:div.bg-white.px-4.py-5.sm:grid.sm:grid-cols-3.sm:gap-4.sm:px-6
      [:dt.text-sm.font-medium.text-gray-500 "Attachments"]
      [:dd.mt-1.text-sm.text-gray-900.sm:mt-0.sm:col-span-2
       [:ul.border.border-gray-200.rounded-md.divide-y.divide-gray-200 {:role "list"}
        [:li.pl-3.pr-4.py-3.flex.items-center.justify-between.text-sm
         [:div.w-0.flex-1.flex.items-center
          [:svg.flex-shrink-0.h-5.w-5.text-gray-400 {:xmlns "http://www.w3.org/2000/svg" :viewBox "0 0 20 20" :fill "currentColor" :aria-hidden "true"}
           [:path {:fill-rule "evenodd" :d "M8 4a3 3 0 00-3 3v4a5 5 0 0010 0V7a1 1 0 112 0v4a7 7 0 11-14 0V7a5 5 0 0110 0v4a3 3 0 11-6 0V7a1 1 0 012 0v4a1 1 0 102 0V7a3 3 0 00-3-3z" :clip-rule "evenodd"}]]
          [:span.ml-2.flex-1.w-0.truncate "resume_back_end_developer.pdf"]]
         [:div.ml-4.flex-shrink-0
          [:a.font-medium.text-indigo-600.hover:text-indigo-500 {:href "#"} "Download"]]]
        [:li.pl-3.pr-4.py-3.flex.items-center.justify-between.text-sm
         [:div.w-0.flex-1.flex.items-center
          [:svg.flex-shrink-0.h-5.w-5.text-gray-400 {:xmlns "http://www.w3.org/2000/svg" :viewBox "0 0 20 20" :fill "currentColor" :aria-hidden "true"}
           [:path {:fill-rule "evenodd" :d "M8 4a3 3 0 00-3 3v4a5 5 0 0010 0V7a1 1 0 112 0v4a7 7 0 11-14 0V7a5 5 0 0110 0v4a3 3 0 11-6 0V7a1 1 0 012 0v4a1 1 0 102 0V7a3 3 0 00-3-3z" :clip-rule "evenodd"}]]
          [:span.ml-2.flex-1.w-0.truncate "coverletter_back_end_developer.pdf"]]
         [:div.ml-4.flex-shrink-0
          [:a.font-medium.text-indigo-600.hover:text-indigo-500 {:href "#"} "Download"]]]]]]]]])
