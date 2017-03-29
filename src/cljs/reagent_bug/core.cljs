(ns reagent-bug.core
  (:require [reagent.core :as reagent :refer [atom]]
            [reagent.session :as session]
            [secretary.core :as secretary :include-macros true]
            [accountant.core :as accountant]))

;; -------------------------
;; Views

(defn home-page []
  [:div [:h2 "Welcome to reagent-bug"]

   ;; Works as Expected
   [:> js/NativeComponent {:test ["props"]}]  ; correctly converts props to js-props
   [(reagent/adapt-react-class js/NativeComponent) {:test ["props"]}]

   ;; Unexpected Behavior
   [:> js/NativeComponent #js {:test ["props"]}] ; incorrectly moves the props to the children
   [(reagent/adapt-react-class js/NativeComponent) #js {:test ["props"]}]]) ; incorrectly moves the props to the children


;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
