(ns im-a-celebrity-exercise.core-test
  (:require [clojure.test :refer :all]
            [im-a-celebrity-exercise.test-data :as test-data]
            [im-a-celebrity-exercise.im-a-celeb-model :as test-case]))

(deftest celebrity-results
  (testing "ordering of celebreties"
    (is (= ["Giovanna Fletcher" "Jordan North" "Vernon Kay" "Sir Mo Farah" "Russell Watson"]
           (test-case/celebs-finishing-position test-data/voting-rounds test-data/celebs))))
  (testing "winner"
    (is (=  "giov"
            (test-case/im-a-celebrity-winner test-data/voting-rounds)))))


