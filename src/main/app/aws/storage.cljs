(ns app.aws.storage
  (:require ["aws-amplify" :refer [Storage]]
            ["/aws-exports" :default aws-config]))

(def bucket (aget aws-config "aws_user_files_s3_bucket"))

(def bucket-region (aget aws-config "aws_user_files_s3_bucket_region"))

(defn image-url [image-name]
  (str "https://" bucket ".s3." bucket-region ".amazonaws.com/public/" image-name))

(image-url "pizza_cookies2.jpeg")

(def default-storage-config {:level "public"})

(defn put-file [name file]
  (.put Storage name file (clj->js (merge default-storage-config
                                          {:contentType (:type file)}))))

(defn get-file
  ([name]
   (get-file name {}))
  ([name config]
   (.get Storage name (clj->js config))))
