echo "Building harmoni..."

yarn build
echo "Build complete. Optimized version ready to release."

aws s3 cp --recursive build s3://harmoni --profile ryanmchenry2
echo "sync completed - s3 is up to date."

read -p "Do you want to commit to GitHub?" yn
    case $yn in
        [Yy]* ) git add .
		read -p "Commit description: " desc
		git commit -m "$desc"
		git push origin master	;;
        [Nn]* ) exit;;
        * ) echo "Please answer yes or no.";;
    esac

echo "Release complete!"
