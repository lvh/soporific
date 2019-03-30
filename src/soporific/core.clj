(ns soporific.core
  (:require
   [hickory.core :as h]
   [clojure.java.io :as io]
   [clojure.string :as str])
  (:gen-class))

(def rfcdash-base-path "/home/user/Projects/rfcdash")

(defn parse-rfcs
  [rfcdash-base-path]
  (->> (io/file rfcdash-base-path "RFCs.docset" "Contents")
       (file-seq)
       (into {}
             (comp
              (filter #(.isFile %))
              (map (juxt
                    (fn [f] (-> f
                                (.getName)
                                (str/split #"\." 1)
                                (first)))
                    (comp h/as-hickory h/parse slurp)))))))

(defonce parsed-rfcs (parse-rfcs rfcdash-base-path))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
