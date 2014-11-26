(ns zenblog.pageandctrl.ctrl
  (:require [net.cgrand.enlive-html :as html]
            [zenblog.pageandctrl.pagelayout :refer :all]
            [com.ashafa.clutch :as cl]
            [zenblog.dbase :as db]
            [hiccup.core :as hc]
            [zenblog.pageandctrl.homepage :refer :all] 
            [zenblog.pageandctrl.postblog :refer :all]
            [zenblog.pageandctrl.blogpage :refer :all]))

;;Pages

(def ctitle " - zenius.net | The next revolution in learning")

;;homepage
(defn homepage []
  (createpage home (str "Home" ctitle)))

;;postblog
(defn postpage []
  (createpage postb (str "Post" ctitle)))

;;blogpage
(defn blogpage [id]
  (createpage #(blogp id) (str "Blog" ctitle)))