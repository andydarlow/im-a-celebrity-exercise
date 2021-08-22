(ns im-a-celebrity-exercise.im-a-celeb-model
  (:gen-class))

;;---------------- utils -----------------------------


(def find-first
  "util to give you the first element that
   matches the predicate function"
  (comp first filter))

;;-------------------- dealing with celebs ----------------

(defn find-celebrity-record
  "gives you the celebrity record for the 
   celeb with the id provided. the record will 
   comtain the id of the celeb and their full name"
  [celeb-list celeb-id]
  (find-first #(= celeb-id (:celeb-id %)) celeb-list))

(defn celebrity-name
  "gives the name of the celeb given their id"
  [celeb-list celeb-id]
  (:name (find-celebrity-record celeb-list celeb-id)))

(defn celebrity-names
  "gives the name of the celeb given their ids
   any unknown names will be ignored"
  [celebs celeb-ids]
  (->> celeb-ids
       (map (partial celebrity-name celebs))
       (remove nil?)))

;;-------------------- functions for process a round of votes ----------------

(defn reverse-chronological-order
  "gives you the rounds so the last vote is
   first in the list, the first set of votes
   is first"
  [voting-rounds]
  (reverse (sort-by :voting-round voting-rounds)))

(defn finale-voting-round
  "gives the round of votes made on the
  finale of i'm a celebrity"
  [voting-rounds]
  (first (reverse-chronological-order voting-rounds)))

(defn ^{:private true} order-by-votes
  "gives the votes ordered by count of votes. Lowest vote
   is first, highest vote last"
  [voting-round]
  (sort-by :count (:votes voting-round)))

(defn highest-vote
  "vote with the highest count in the round passed in 
  (returns the celeb id and the the votes for them - count) "
  [voting-round]
  (last (order-by-votes voting-round)))

(defn lowest-vote
  "vote with the lowest count in the round passed in 
  (returns the celeb id and the the votes for them - count).
   one celeb is chosen (rather than list all winers)"
  [voting-round]
  (first (order-by-votes voting-round)))

(defn winning-celebrity-of-round
  "this gives the id of the celebrity who won a round
   of votes from the public. Note if there is a tie, "
  [voting-round]
  (:celeb-id (highest-vote voting-round)))

(defn evicted-celebrity
  "id of celeb that got evicted out the 
   competition in this round"
  [voting-round]
  (:celeb-id (lowest-vote voting-round)))


;;-------------------- functions to question about the show ----------------


(defn im-a-celebrity-winner
  "id of the celeb who won the i'm a celebrity"
  [voting-rounds]
  (winning-celebrity-of-round (finale-voting-round voting-rounds)))

(defn celeb-eviction-list
  "id list of the celebs that got evicted in 
   reverse chronological order (i.e first eveiction
   is at the end of the list). Note winner isnt in the list"
  [voting-rounds]
  (map evicted-celebrity (reverse-chronological-order voting-rounds)))

(defn celebs-finishing-position
  "ordered list of the celebs with the winner
   at the top and the first evicted at the bottom"
  [voting-rounds celebs]
  (let [celeb-ids (cons (im-a-celebrity-winner voting-rounds)
                        (celeb-eviction-list voting-rounds))]
    (celebrity-names celebs celeb-ids)))
