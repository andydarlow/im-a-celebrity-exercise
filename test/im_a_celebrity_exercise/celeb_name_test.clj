(ns im-a-celebrity-exercise.celeb-name-test
  (:require [clojure.test :refer :all]
            [im-a-celebrity-exercise.test-data :as test-data]
            [im-a-celebrity-exercise.im-a-celeb-model :as test-case]))

(deftest celebrety-name-lookup
  (testing "find matching id"
    (is (=  "Russell Watson"
            (test-case/celebrity-name test-data/celebs "wats"))))
  (testing "unknown name"
    (is (nil? (test-case/celebrity-name test-data/celebs "uuu")))))

(deftest celebrety-names-lookup
  (testing "find matching ids"
    (is (=  ["Russell Watson" "Jordan North"]
            (test-case/celebrity-names test-data/celebs ["wats", "jord"]))))
  (is (=  ["Russell Watson" "Jordan North"]
          (test-case/celebrity-names test-data/celebs ["wats", "unk" "jord"]))))

