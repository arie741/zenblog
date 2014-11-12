(ns zenblog.pageandctrl.blogpage
  (:require [net.cgrand.enlive-html :as html]
            [zenblog.pageandctrl.pagelayout :refer :all]
            [com.ashafa.clutch :as cl]
            [zenblog.dbase :as db]
            [hiccup.core :as hc]
            ))

(defn blogarticle []
  (hc/html [:div {:class "panel"} "\n    " [:h2 {} [:bjudul {}]] "\n    " [:p {} [:bisi {}]]]))

(html/deftemplate blogp "selmer/blogpage.html"
  [id]
  [:blogarticle] (html/html-content (blogarticle))
  [:bjudul] (html/content (:Judul (db/findById id)))
  [:bisi] (html/content (:Isi (db/findById id)))
  )
