(ns zenblog.pageandctrl.postblog
  (:require [net.cgrand.enlive-html :as html]
            [zenblog.pageandctrl.pagelayout :refer :all]
            [com.ashafa.clutch :as cl]
            [zenblog.dbase :as db]
            [hiccup.core :as hc]
            ))

(defn post [judul isi]
  (cl/put-document "zenblog" {:judul judul :isi isi :cId (+ (db/countblog) 1) :Type "article"}))

(html/deftemplate postb "selmer/postblog.html"
  [])