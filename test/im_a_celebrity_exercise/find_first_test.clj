(ns im-a-celebrity-exercise.find-first-test
  (:require [clojure.test :refer :all]
            [im-a-celebrity-exercise.im-a-celeb-model :as test-case]))

(deftest find-first
  (testing "find element in list"
    (is (= 5 (test-case/find-first #(> % 4) [2 3 4 5 6]))))
  (testing "No matches"
    (is (nil? (test-case/find-first #(> % 10) [2 3 4 5 6]))))
  (testing "empty List"
    (is (nil? (test-case/find-first #(> % 10) []))))
  (testing "identical entries in List"
    (is (= 10 (test-case/find-first #(> % 9) [10 10 10 10])))))