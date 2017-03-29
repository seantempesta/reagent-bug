(ns reagent-bug.prod
  (:require [reagent-bug.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
