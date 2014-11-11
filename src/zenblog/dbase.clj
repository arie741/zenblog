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
  (first (filter #(hasId % id) (dbvalues))))

(defn countblog []
  (count (dbvalues)))

