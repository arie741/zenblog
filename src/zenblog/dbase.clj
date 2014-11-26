(ns zenblog.dbase
  (:require [cemerick.url :as curl]
            [com.ashafa.clutch :as cl]))

(def couch (assoc (curl/url "https://cloudant-account-name.cloudant.com/" "databasename")
          :username "username"
          :password "password"))

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

(def mydb (atom {}))

(defn get-by-id [id]
  (get @mydb id))

(defn uuid [] (str (java.util.UUID/randomUUID)))

(defn add-art [judul isi]
  (swap! mydb assoc (uuid) {:judul judul :isi isi}))


