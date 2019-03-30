(defproject soporific "0.1.0-SNAPSHOT"
  :description "RFC data analysis"
  :url "https://github.com/lvh/soporific"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [hickory "0.7.1"]
                 [com.taoensso/timbre "4.10.0"]
                 [datascript "0.18.2"]]
  :main ^:skip-aot soporific.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
