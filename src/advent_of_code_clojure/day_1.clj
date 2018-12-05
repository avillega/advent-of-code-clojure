(ns advent-of-code-clojure.day-1
  (:require [clojure.string :as str]))

(defn find-dup [seen-elems elem]
  (if (seen-elems elem)
    (reduced elem)
    (conj seen-elems elem)))

(def num-list (->> (slurp "resources/input-day-1.txt")
                   (str/split-lines)
                   (mapv  #(Integer/parseInt %))))

(defn solve [reduc start ls]
  (let [inter-results (reductions + start ls)
        last-e (last inter-results)
        v (reduce find-dup reduc (rest inter-results))]
    (if ((complement coll?) v)
      v
      (recur v last-e ls))))

(solve #{} 0 num-list)

