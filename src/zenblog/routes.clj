(ns zenblog.routes
  (:require [compojure.core :refer :all]
            [zenblog.layout :as page]
            [zenblog.pageandctrl.ctrl :as pages]
            [zenblog.pageandctrl.postblog :as post]
            [noir.response :as resp]))


(defroutes home
  (GET "/" req
       (pages/homepage))
  (GET "/post" req
       (pages/postpage))
  (POST "/action-post" req
        (let [bjudul (:judul (:params req))
              bisi (:isi (:params req))]
          (do (post/post bjudul bisi) 
            (resp/redirect "/")))))
