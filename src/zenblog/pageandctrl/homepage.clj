(ns zenblog.pageandctrl.homepage
  (:require [net.cgrand.enlive-html :as html]
            [zenblog.pageandctrl.pagelayout :refer :all]
            [com.ashafa.clutch :as cl]
            [zenblog.dbase :as db]
            [hiccup.core :as hc]
            ))


(defn blog [kjudul kisi kid]
  (hc/html [:div {:class "panel"} "\n    " [:h2 {} [kjudul {}]] "\n    " [:p {} [kisi {}] "... " [:a {:href (str "/blog/" kid)} "Baca Selengkapnya"]]]))

(defn blogtemplate [blognum]
  (if (zero? blognum)
    ""
    (str (blogtemplate (dec blognum)) (blog (keyword (str "bjudul" blognum)) (keyword (str "bisi" blognum)) blognum))))

(defn sort-by-rate [rank]
  (first (db/find-by-rate (- (db/top-rate) rank))))

(html/deftemplate home "selmer/home.html"
  []
  [:blogtemplate] (html/html-content (blogtemplate (db/countart)))
  [:bjudul1] (html/content (:judul (sort-by-rate 0)))
  [:bisi1] (html/content (apply str (take 600 (:isi (sort-by-rate 0)))))
  [:bjudul2] (html/content (:judul (sort-by-rate 1)))
  [:bisi2] (html/content (apply str (take 600 (:isi (sort-by-rate 1)))))
  [:bjudul3] (html/content (:judul (sort-by-rate 2)))
  [:bisi3] (html/content (apply str (take 600 (:isi (sort-by-rate 2)))))
  [:bjudul4] (html/content (:judul (sort-by-rate 3)))
  [:bisi4] (html/content (apply str (take 600 (:isi (sort-by-rate 3)))))
  [:bjudul5] (html/content (:judul (sort-by-rate 4)))
  [:bisi5] (html/content (apply str (take 600 (:isi (sort-by-rate 4)))))
  [:bjudul6] (html/content (:judul (sort-by-rate 5)))
  [:bisi6] (html/content (apply str (take 600 (:isi (sort-by-rate 5)))))
  )


