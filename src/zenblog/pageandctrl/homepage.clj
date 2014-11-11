(ns zenblog.pageandctrl.homepage
  (:require [net.cgrand.enlive-html :as html]
            [zenblog.pageandctrl.pagelayout :refer :all]
            [com.ashafa.clutch :as cl]
            [zenblog.dbase :as db]
            [hiccup.core :as hc]
            ))


(defn blog [kjudul kisi]
  (hc/html [:div {:class "panel"} "\n    " [:h2 {} [kjudul {}]] "\n    " [:p {} [kisi {}] "... " [:a {:href "/blog1"} "Baca Selengkapnya"]]]))

(defn blogtemplate [blognum]
  (if (zero? blognum)
    ""
    (str (blog (keyword (str "bjudul" blognum)) (keyword (str "bisi" blognum))) (blogtemplate (dec blognum)))))


(html/deftemplate home "selmer/home.html"
  []
  [:blogtemplate] (html/html-content (blogtemplate (db/countblog)))
  [:bjudul6] (html/content (:Judul (db/findById 6)))
  [:bisi6] (html/content (:Isi (db/findById 6)))
  [:bjudul5] (html/content (:Judul (db/findById 5)))
  [:bisi5] (html/content (:Isi (db/findById 5)))
  [:bjudul4] (html/content (:Judul (db/findById 4)))
  [:bisi4] (html/content (:Isi (db/findById 4)))
  [:bjudul3] (html/content (:Judul (db/findById 3)))
  [:bisi3] (html/content (:Isi (db/findById 3)))
  [:bjudul2] (html/content (:Judul (db/findById 2)))
  [:bisi2] (html/content (:Isi (db/findById 2)))
  [:bjudul1] (html/content (:Judul (db/findById 1)))
  [:bisi1] (html/content (:Isi (db/findById 1)))
  )


