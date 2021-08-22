(ns im-a-celebrity-exercise.test-data
  (:require [clojure.test :refer :all]
            [clj-time.core :as t]
            [im-a-celebrity-exercise.im-a-celeb-model :refer :all]))

;; samples test data representing the votes in in im a celebrity
;; get me out of here

(def celebs [{:celeb-id "jord" :name "Jordan North"}
             {:celeb-id "giov" :name "Giovanna Fletcher"}
             {:celeb-id "wats" :name "Russell Watson"}
             {:celeb-id "kay"  :name "Vernon Kay"}
             {:celeb-id "Mo"   :name "Sir Mo Farah"}])

(def voting-rounds [{:voting-round 4
                     :vote-date (t/date-time 2020 12 10)
                     :votes [{:celeb-id "giov" :count 123333}
                             {:celeb-id "jord" :count 112223}]}
                    {:voting-round 3
                     :vote-date (t/date-time 2020 12 3)
                     :votes [{:celeb-id "giov" :count 87655}
                             {:celeb-id "jord" :count 67887}
                             {:celeb-id "kay"  :count 60000}]}
                    {:voting-round 2
                     :vote-date (t/date-time 2020 11 26)
                     :votes [{:celeb-id "giov" :count 41661}
                             {:celeb-id "Mo"   :count 35556}
                             {:celeb-id "jord" :count 42500}
                             {:celeb-id "kay"  :count 42000}]}
                    {:voting-round 1
                     :vote-date (t/date-time 2020 11 19)
                     :votes [{:celeb-id "giov" :count 45566}
                             {:celeb-id "Mo"   :count 50001}
                             {:celeb-id "jord" :count 30000}
                             {:celeb-id "wats" :count 28701}
                             {:celeb-id "kay"  :count 334598}]}])
