(ns advent-of-code-clojure.day-2
  (:require [clojure.string :as str]))

(def ids (->> (slurp "resources/input-day-2.txt")
              (str/split-lines)))

(defn solve-part-1 [ids]
  (let [value (flatten (for [id ids]
                         (->> (frequencies id)
                              (map second)
                              (filter #{2 3})
                              (distinct))))]
    (reduce #(* (second %1) (second %2))(frequencies value))))

(solve-part-1 ids)


(defn differ-by-one [str1 str2]
  (loop [str1 str1
         str2 str2
         count 0]
    (cond
      (not (seq str1)) true
      (> count 1) false
      (= (first str1) (first str2)) (recur (next str1) (next str2) count)
      (not= (first str1) (first str2)) (recur (next str1) (next str2) (inc count))
      :else true)))

(defn solve-part-2 [ids]
  (for [x ids y ids
        :when (and (not= x y)
                   (differ-by-one x y))]
    [x y]))

(solve-part-2 ids)
;; This wil give you the pair that differs only in one char not the answer to the challenge
