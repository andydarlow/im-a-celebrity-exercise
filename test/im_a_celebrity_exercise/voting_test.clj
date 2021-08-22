(ns im-a-celebrity-exercise.voting-test
  (:require [clojure.test :refer :all]
            [clj-time.core :as t]
            [im-a-celebrity-exercise.im-a-celeb-model :as test-case]))

(deftest lowest-voting
  (testing "lowest vote in list "
    (is (= "jord" (test-case/evicted-celebrity
                   {:voting-round 4
                    :vote-date (t/date-time 2020 12 10)
                    :votes [{:celeb-id "giov" :count 123333}
                            {:celeb-id "jord" :count 112223}]}))))

  (testing "same votes "
    (is (= "giov" (test-case/evicted-celebrity
                   {:voting-round 4
                    :vote-date (t/date-time 2020 12 10)
                    :votes [{:celeb-id "giov" :count 10}
                            {:celeb-id "jord" :count 10}]})))))

(deftest highest-voting
  (testing "highest vote in list "
    (is (= "giov" (test-case/winning-celebrity-of-round
                   {:voting-round 4
                    :vote-date (t/date-time 2020 12 10)
                    :votes [{:celeb-id "giov" :count 123333}
                            {:celeb-id "jord" :count 112223}]}))))

  (testing "same votes "
    (is (= "jord" (test-case/winning-celebrity-of-round
                   {:voting-round 4
                    :vote-date (t/date-time 2020 12 10)
                    :votes [{:celeb-id "giov" :count 10}
                            {:celeb-id "jord" :count 10}]})))))