(ns zenblog.dbase
  (:require [cemerick.url :as curl]
            [com.ashafa.clutch :as cl]))

(def couch (assoc (curl/url "https://cloudant-account-name.cloudant.com/" "databasename")
          :username "username"
          :password "password"))

;;db as couch
(def db "zenblog")

(defn dbvalues []
  (map :value (cl/get-view db "article" "byId")))

(defn hasId [dat id]
  (if (= (:cId dat) id)
    true
    false))

(defn findById [id]
  (assert (integer? id))
  (first (filter #(hasId % id) (dbvalues))))

(defn countblog []
  (count (dbvalues)))

;;;db as atom

(def dbloc "resources/dbase.txt")

(def mydb (atom (read-string (slurp dbloc))))

(defn get-by-id [id]
  (get @mydb id))

(defn uuid [] (str (java.util.UUID/randomUUID)))

(defn add-art [judul isi]
  (swap! mydb assoc (uuid) {:judul judul :isi isi :rate 0}))

(defn dbvals []
  (vals @mydb))

(defn find-vals [dat val]
  (if (= (first (vals dat)) val)
  (keys dat)
  nil))

(defn rate? [dat rate]
  (if (= (:rate dat) rate)
    true
    false))

(defn find-by-rate [rate]
  (assert (integer? rate))
  (filter #(rate? % rate) (dbvals)))

(defn top-rate []
  (apply max (map :rate (dbvals))))

(defn countart []
  (count (dbvals)))
