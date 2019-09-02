# MaterialDialog

[![](https://jitpack.io/v/Gymkhana-Studio/MaterialDialog.svg)](https://jitpack.io/#Gymkhana-Studio/MaterialDialog)



Example Usage
```
new MaterialDialog.Builder(MainActivity.this)
   .setTitle("Material Dialog")
   .setMessage("Author: Gymkhana Studio")
   .setTextButton("Download")
   .setAnimation(Animation.UP)
   .setIcon(R.drawable.ic_launcher)
   .setOnClicked(new MaterialDialogListener(){
      @Override
      public void OnClick(){
         Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_LONG).show();
      }
   })
.show();

```
