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
              (map
               (fn [f]
                 (let [friendly (-> f (.getName) (str/split #"\." 1) (first))
                       contents (slurp f)]
                   [friendly
                    {::contents contents
                     ::hickory (-> contents h/parse h/as-hickory)}])))))))

(defonce parsed-rfcs (parse-rfcs rfcdash-base-path))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
