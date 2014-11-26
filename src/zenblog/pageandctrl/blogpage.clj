(ns zenblog.pageandctrl.blogpage
  (:require [net.cgrand.enlive-html :as html]
            [zenblog.pageandctrl.pagelayout :refer :all]
            [com.ashafa.clutch :as cl]
            [zenblog.dbase :as db]
            [hiccup.core :as hc]))


(html/deftemplate blogp "selmer/blogpage.html"
  [id]
  [:bjudul] (html/content (:Judul (db/findById id)))
  [:bisi] (html/content (:Isi (db/findById id))))

;;;


